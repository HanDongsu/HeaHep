package HeaHep.controller.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import HeaHep.service.HMemberService;
import HeaHep.vo.HMember;
import HeaHep.vo.JsonResult;

@Controller
@RequestMapping({"/hMember/"})
public class HMemberController {
	@Autowired HMemberService hMembersService;
	@Autowired ServletContext sc;

	@RequestMapping(path="joinMember")
	public Object joinMember(HMember hMember) throws Exception {
		try {
		  hMembersService.singUpMembers(hMember);
			return JsonResult.success();
		} catch (Exception e) {
			return JsonResult.fail(e.getMessage());
		}
	}


}