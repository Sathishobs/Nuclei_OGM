/**
 * 
 */
package nuclei.controller;

import javax.servlet.http.HttpServletResponse;

import nuclei.domain.Member;
import nuclei.service.MemberService;
import nuclei.service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sathish
 *
 */

@RestController
public class MemberController extends Controller<Member>{

	@Autowired
    private MemberService memberService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("welcome", new Member());
        return "welcome";
    }
	
    @RequestMapping(value = "/members", method= RequestMethod.GET)
    public Iterable<Member> list(final HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        return super.list();
    }
    @RequestMapping(value = "/member", method = RequestMethod.POST, consumes = "application/json")
	public Member create(@RequestBody Member entity, final HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        return super.create(entity);
    }

    @RequestMapping(value="/member/{id}", method = RequestMethod.GET)
    public Member find(@PathVariable Long id, final HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        return super.find(id);
    }

    @RequestMapping(value="/member/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable Long id, final HttpServletResponse response) {
        setHeaders(response);
        super.delete(id);
    }

    @RequestMapping(value="/member/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public Member update (@PathVariable Long id, @RequestBody Member entity, final HttpServletResponse response) {
        setHeaders(response);
        return super.update(id, entity);
    }

    @Override
    public Service<Member> getService() {
        return memberService;
    }

}
