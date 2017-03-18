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
	@Autowired HMemberService hMembersService;
	@Autowired ServletContext sc;
	@Autowired HMemberDao hMemberDao;

	@RequestMapping(path="joinMember")
	public Object joinMember(HMember hMember) throws Exception {
		try {
		  hMembersService.singUpMembers(hMember);
			return JsonResult.success();
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}
	@RequestMapping(path="login")
  public Object login(
      HttpSession session,
      String memberEmail,
      String memberPWD,
      SessionStatus sessionStatus) throws Exception {
	 Cookie cookie = new Cookie("key", "value");
    try {
      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("email", memberEmail);
      paramMap.put("password", memberPWD);
      HMember hMember = hMemberDao.selectOneByEmailAndPassword(paramMap);
      
      if (hMember == null) {
        sessionStatus.setComplete();
        return JsonResult.fail();
      } else {
        session.setAttribute("member", hMember);
        session.setMaxInactiveInterval(60*60*24*30);
        return JsonResult.success();
      }
    } catch (Exception e) {
      return JsonResult.error(e.getMessage());
    }
  }

	@RequestMapping(path="changeMemberInfo")
	public Object changeMemberInfo(HMember hMember) throws Exception {
	  try {
	    hMembersService.changeInfromation(hMember);
	    return JsonResult.success();
	  } catch (Exception e) {
	    return JsonResult.fail(e.getMessage());
	  }
	}


}