(function() {
	var userService = new UserService();

	var rowTemplate;
	var tBody;
	var usernameFld;
	var passwordFld;
	var firstNameFld;
	var lastNameFld;
	var roleFld;

	var idToBeEdited;

	var createBtn;
	var deleteBtn;
	var editBtn;
	var updateBtn;
	var searchBtn;

	jQuery(main);

	function main() {
		rowTemplate = jQuery('.wbdv-template');
		tBody = $('tbody');
		usernameFld = $('#usernameFld');
		passwordFld = $('#passwordFld');
		firstNameFld = $('#firstNameFld');
		lastNameFld = $('#lastNameFld');
		roleFld = $('#roleFld');

		createBtn = $('.wbdv-create');
		deleteBtn = $('.wbdv-remove');
		editBtn = $('.wbdv-edit');
		updateBtn = $('.wbdv-update');
		searchBtn = $('.wbdv-search');

		userService.findAllUsers().then(renderUsers);

		// using click() method to accomplish direct binding for static elements
		createBtn.click(createUser);
		updateBtn.click(updateUser);
		searchBtn.click(searchUser);

		// using on() method to accomplish delegated binding for dynamically
		// created elements
		$(document).on('click', '.wbdv-remove', deleteUser);
		$(document).on('click', '.wbdv-edit', selectUser);
	}

	function searchUser(){
		const username = usernameFld.val();
		const password = passwordFld.val();
		const firstName = firstNameFld.val();
		const lastName = lastNameFld.val();
		const role = roleFld.val();
		userToBeSearched = new User(username,password,firstName,lastName,role);
		
		userService.searchUser(userToBeSearched).then(renderUsers);
		clearForm();
		
		
	}
	
	function updateUser() {
		userService.updateUser(idToBeEdited, userInfoPickingHelper()).then(
				renderUsers);
		clearForm();
	}

	function selectUser(event) {
		currentTarget = $(event.currentTarget)
		idToBeEdited = $(currentTarget).attr('id')

		const tr = currentTarget.parent().parent().parent()

		usernameFld.val(tr.find('.wbdv-username').text())
		firstNameFld.val(tr.find('.wbdv-first-name').text())
		lastNameFld.val(tr.find('.wbdv-last-name').text())
		roleFld.val(tr.find('.wbdv-role').text())
	}

	function deleteUser(event) {
		currentTarget = $(event.currentTarget)
		const idToBeDeleted = $(currentTarget).attr('id')
		userService.deleteUser(idToBeDeleted).then(renderUsers);
	}

	function createUser() {
		userService.createUser(userInfoPickingHelper()).then(renderUsers);
		clearForm();
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
			rowClone.find('.wbdv-role').html(user.role);
			rowClone.find('.wbdv-remove').attr("id", user.id);
			rowClone.find('.wbdv-edit').attr("id", user.id);
			tBody.append(rowClone);
		}
	}

	function clearForm() {
		usernameFld.val("");
		passwordFld.val("");
		firstNameFld.val("");
		lastNameFld.val("");
	}

	function userInfoPickingHelper() {
		const username = usernameFld.val();
		const password = passwordFld.val();
		const firstName = firstNameFld.val();
		const lastName = lastNameFld.val();
		const role = roleFld.val();

		var newlyCreatedUser = {
			username : username,
			password : password,
			firstName : firstName,
			lastName : lastName,
			role : role
		}
		return newlyCreatedUser;
	}

})()
