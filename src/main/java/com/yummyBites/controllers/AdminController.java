package com.yummyBites.controllers;


//
//@RestController
//@SecurityRequirement(name = "restaurant-docs")
public class AdminController {

//	@Autowired
//	private AdminService adminService;

//	@PreAuthorize("hasRole('ADMIN')")
//	@GetMapping("/admin/login")
//	public ModelAndView adminLogin() {
//		ModelAndView mav = new ModelAndView("adminLogin");
//		return mav;
//	}

//	@PreAuthorize("hasRole('ADMIN')")
//	@PostMapping("/admin/index")
//	public ModelAndView adminPage(@Valid @ModelAttribute("admindata") AdminData admindata, BindingResult result) {
//		if (result.hasErrors()) {
//			System.out.println(result);
//
//		}
//		System.out.println(admindata.getUserName());
//		AdminData adminData1 = adminService.getDataById(1);
//		if (adminData1.getUserName().equals(admindata.getUserName())
//				&& adminData1.getPassword().equals(admindata.getPassword())) {
//			ModelAndView mav1 = new ModelAndView("admin");
//			return mav1;
//		}
//		ModelAndView mav2 = new ModelAndView("adminLogin");
//		return mav2;
//	}

//	@PostMapping("/logout")
//	public void logout(HttpServletRequest request) {
//		request.getSession().invalidate();
//	}
}
