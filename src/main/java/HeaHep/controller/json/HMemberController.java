package HeaHep.controller.json;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
//	@RequestMapping(path="login")
//  public Object login(
//      HttpSession session,
//      String memberEmail,
//      String memberPWD,
//      SessionStatus sessionStatus) throws Exception {
//	 Cookie cookie = new Cookie("key", "value");
//    try {
//      HashMap<String,Object> paramMap = new HashMap<>();
//      paramMap.put("email", memberEmail);
//      paramMap.put("password", memberPWD);
//      HMember hMember = hMemberDao.selectOneByEmailAndPassword(paramMap);
//      
//      if (hMember == null) {
//        sessionStatus.setComplete();
//        return JsonResult.fail();
//      } else {
//        session.setAttribute("member", hMember);
//        session.setMaxInactiveInterval(60*60*24*30);
//        return JsonResult.success();
//      }
//    } catch (Exception e) {
//      return JsonResult.error(e.getMessage());
//    }
//  }
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