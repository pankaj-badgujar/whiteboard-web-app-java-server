(function() {
	var userService = new UserService();

		var rowTemplate;
		var tBody;
		
		jQuery(main);
		
		function main(){
			rowTemplate = jQuery('.wbdv-template');
			tBody = $('tbody');
			
			userService
			.findAllUsers()
			.then(renderUsers);
		
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
