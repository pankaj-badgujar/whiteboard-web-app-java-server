(function() {
	var userService = new UserService();

		var rowTemplate;
		var tBody;
		var usernameFld;
		var passwordFld;
		var firstNameFld;
		var lastNameFld;
		var roleFld;
		
		var createBtn;
		
		jQuery(main);
		
		function main(){
			rowTemplate = jQuery('.wbdv-template');
			tBody = $('tbody');
			usernameFld = $('#usernameFld');
			passwordFld = $('#passwordFld');
			firstNameFld = $('#firstNameFld');
			lastNameFld = $('#lastNameFld');
			roleFld = $('#roleFld');
			
			createBtn = $('.wbdv-create');
			
			userService
			.findAllUsers()
			.then(renderUsers);
			
			createBtn.click(createUser);
		
		}
		
	function createUser(){
		const username = usernameFld.val();
		const password = passwordFld.val();
		const firstName = firstNameFld.val();
		const lastName = lastNameFld.val();
		const role = roleFld.val();
		
		var newlyCreatedUser = {
				username: username,
				password: password,
				firstName: firstName,
				lastName: lastName,
				role: role
		}
		
		userService.createUser(newlyCreatedUser);
		
	}

	function renderUsers(users) {
		tBody.empty();
		for ( var i in users) {
			const user = users[i];
			const rowClone = rowTemplate.clone();
			rowClone.removeClass('wbdv-hidden');
			rowClone.find('.wbdv-username').html(user.username);
			rowClone.find('.wbdv-first-name').html(user.firstName);
			rowClone.find('.wbdv-last-name').html(user.lastName);
			rowClone.find('wbdv-role').html(user.role);
			tBody.append(rowClone);
		}
	}

})()
