package com.itchan.oauthsecurityjwt.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/rest")
public class UserController {
	
	
	@PreAuthorize("hasRole('create_note')")
	@PostMapping("/create")
	public String create() {
		
		return "Create successfuly";
	}
	
	@PreAuthorize("hasRole('view_note')")
	@GetMapping("/view")
	public String view() {
		return "Display Successfuly";
	}
	
	@PreAuthorize("hasRole('edit_note')")
	@PutMapping("/update")
	public String update() {
		return "Update Successfuly";
	}
	
	@PreAuthorize("hasRole('delete_note')")
	@DeleteMapping("/delete")
	public String delete() {
		return "deleted Successfuly";
	}
	

}
