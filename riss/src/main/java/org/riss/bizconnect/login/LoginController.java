/*
 * package org.riss.bizconnect.login;
 * 
 * import javax.servlet.http.HttpSession;
 * 
 * import org.riss.bizconnect.main.member.model.dto.User; import
 * org.riss.bizconnect.main.member.model.service.MemberService; import
 * org.riss.bizconnect.main.member.model.dto.Member; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.support.SessionStatus;
 * 
 * @Controller public class LoginController {
 * 
 * @Autowired private MemberService memberService;
 * 
 * // 로그인 페이지로 이동하는 메소드
 * 
 * @RequestMapping("/loginPage.do") public String showLoginPage() { return
 * "common/loginPage"; // member/loginPage.jsp로 이동 }
 * 
 * // 로그인 처리 메소드
 * 
 * @PostMapping("/login.do") public String login(User user, HttpSession session,
 * SessionStatus status, Model model) { // 유저 ID를 통해 DB에서 해당 유저 정보 조회 Member
 * loginUser = memberService.selectMember(user.getUserId());
 * 
 * // 암호화된 비밀번호 비교 if (loginUser != null &&
 * memberService.matchPassword(user.getUserPwd(), loginUser.getUserPwd())) {
 * session.setAttribute("loginUser", loginUser); // 세션에 로그인 사용자 정보 저장
 * status.setComplete(); // 로그인 상태 완료 return "redirect:/main"; // 로그인 성공 시 메인
 * 페이지로 리다이렉트 } else { // 로그인 실패 시 에러 메시지 전달 model.addAttribute("message",
 * "로그인 실패! 아이디나 암호를 다시 확인하세요."); return "common/error"; // 에러 페이지로 이동 }
 * 
 * }
 * 
 * // 로그아웃 처리 메소드
 * 
 * @RequestMapping("/logout.do") public String logout(HttpSession session, Model
 * model) { if (session != null) { session.invalidate(); // 세션 무효화 return
 * "redirect:/main"; // 로그아웃 후 메인 페이지로 이동 } else { model.addAttribute("message",
 * "로그인 세션이 존재하지 않습니다."); return "common/error"; // 에러 페이지로 이동 } }
 * 
 * }
 * 
 * 
 * 
 * @Controller
 * 
 * @RequestMapping("login.do") // 클래스 레벨에서 경로를 설정 public class LoginController {
 * 
 * @Autowired private MemberService memberService; // @Autowired로
 * memberService주입
 * 
 * @RequestMapping("loginPage.do") public String showLoginPage() { return
 * "common/loginPage"; // loginPage.jsp로 이동 }
 * 
 * 
 * @PostMapping("login.do") // POST 방식으로 login.do 경로로 오는 요청을 처리 public String
 * login(@RequestParam("gid")String userId,
 * 
 * @RequestParam("user_pw")String userPwd,
 * 
 * @RequestParam("com_code")String comCode,Model model){User user=new
 * User(userId,userPwd,comCode);User
 * authenticatedUser=memberService.selectLogin(user);
 * 
 * if(authenticatedUser!=null){return"redirect:/main";}else{model.addAttribute(
 * "error","Invalid credentials. Please try again.");return"loginPage"; } } }
 * 
 * 
 * 
 * 
 * 
 * package org.riss.bizconnect.login;
 * 
 * import org.riss.bizconnect.main.member.model.dto.User; import
 * org.riss.bizconnect.main.member.model.service.MemberService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam;
 * 
 * @Controller
 * 
 * @RequestMapping("/login") // Base URL for this controller public class
 * LoginController {
 * 
 * @Autowired private MemberService memberService; // Autowired memberService
 * 
 * // GET request handler for /loginPage.do - shows the login page
 * 
 * @RequestMapping("/loginPage") public String showLoginPage() { return
 * "loginPage"; // Return loginPage.jsp view }
 * 
 * // GET request handler for /login.do - redirect to loginPage.do
 * 
 * @RequestMapping(value = "login.do", method = RequestMethod.GET) public String
 * redirectToLoginPage() { return "redirect:/loginPage.do"; // Redirect GET
 * requests to the login page }
 * 
 * // POST request handler for /login.do - handles login submission
 * 
 * @PostMapping("/login.do") public String login(@RequestParam("gid") String
 * userId,
 * 
 * @RequestParam("user_pw") String userPwd,
 * 
 * @RequestParam("com_code") String comCode, Model model) { User user = new
 * User(userId, userPwd, comCode); User authenticatedUser =
 * memberService.selectLogin(user);
 * 
 * if (authenticatedUser != null) { return "redirect:/main"; // Redirect to main
 * page on success } else { model.addAttribute("error",
 * "Invalid credentials. Please try again."); return "loginPage"; // Return
 * loginPage.jsp with an error message } } }
 * 
 * 
 * 
 * 
 * 
 * 
 */