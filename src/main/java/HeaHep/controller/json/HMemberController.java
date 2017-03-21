package HeaHep.controller.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import HeaHep.dao.HMemberDao;
import HeaHep.service.HMemberService;
import HeaHep.vo.HMember;
import HeaHep.vo.JsonResult;

@Controller
@RequestMapping({"/hMember/"})
@SessionAttributes({"HMember"})
public class HMemberController {
	@Autowired HMemberService hMemberService;
	@Autowired ServletContext sc;
	@Autowired HMemberDao hMemberDao;
	
	@RequestMapping(path="joinMember")
	public Object joinMember(HMember hMember) throws Exception {
		try {
		  hMemberService.singUpMembers(hMember);
			return JsonResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.fail(e.getMessage());
		}
	}
	@RequestMapping(path="checkedEmail")
	public Object checkedEmail(String memberEmail) throws Exception {
	  try {
	    if(hMemberService.checkedEmail(memberEmail) == null) {
	      return JsonResult.success();
	    } else {
	      return JsonResult.fail();
	    }
	  } catch(Exception e) {
	    e.printStackTrace();
      return JsonResult.error(e.getMessage());
	  }
	}
	@RequestMapping(path="login")
	public Object login(
			HttpSession session,
			HttpServletResponse response,
			String memberEmail,
			String memberPWD,
			Model model,
			SessionStatus sessionStatus) throws Exception {
		try {
		  HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("memberEmail", memberEmail);
      paramMap.put("memberPWD", memberPWD);
      System.out.println(paramMap.get("memberEmail"));
      System.out.println(paramMap.get("memberPWD"));
			Cookie cookie = new Cookie("memberEmail", memberEmail);
//      if (!saveCookie) {
//        cookie.setMaxAge(0); 
//      } else {
//        cookie.setMaxAge(60 * 60 * 24 * 30);
//      }
//			cookie.setMaxAge(60 * 60 * 24 * 30);
      response.addCookie(cookie);
      response.addCookie(new Cookie("memberPWD", memberPWD));
			
			
			HMember hMember = hMemberDao.selectOneByEmailAndPassword(paramMap);
			
			if (hMember == null) {
				sessionStatus.setComplete(); //세션 무효화
				return JsonResult.fail();
			} else {
	      model.addAttribute("member", hMember); // 모델에 로그인 회원 정보 담기
//				session.setAttribute("member", hMember);
//				session.setMaxInactiveInterval(60*60*24*30);
	      System.out.println("model: "+model);
				return JsonResult.success();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonResult.error(e.getMessage());
		}
	}
//	@RequestMapping(path="userInfoDetail")
//	public Object userInfoDetail(HttpSession session) throws Exception {
//		// 이 메서드는 DB에서 작업할 일이 없어서 service 클래스에서 따로 구현할 필요가 없을 것 같다.
//		try {
//			HMember hMember = (HMember)session.getAttribute("member");
//			if(hMember == null) {
//				System.out.println("해당 회원 정보가 없습니다.");
//			}
//			HMember user = hMemberService.getUserInfo(hMember.getMemberNo());
//			System.out.println(user);
//			return JsonResult.success(user);
//		} catch (Exception e) {
//			return JsonResult.fail(e.getMessage());
//		}
//	}
//	
//
//	@RequestMapping(path="changeMemberInfo")
//	public Object changeMemberInfo(HMember hMember) throws Exception {
//	  try {
//	    hMemberService.changeInfromation(hMember);
//	    return JsonResult.success();
//	  } catch (Exception e) {
//	    return JsonResult.fail(e.getMessage());
//	  }
//	}


}