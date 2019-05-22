function UserService() {
	this.findAllUsers = findAllUsers;
	this.createUser = createUser;
	this.deleteUser = deleteUser;
	this.updateUser = updateUser;
	this.searchUser = searchUser;
	this.findUserById = findUserById;
	
	function findUserById(id){
		return fetch('https://secret-earth-88750.herokuapp.com/api/users/'+id).then(
				function(response) {
					return response.json()
				})
	}
	
	function searchUser(user){
		return fetch('https://secret-earth-88750.herokuapp.com/api/users/',{
			method : 'PUT',
			body : JSON.stringify(user),
			headers : {
				'content-type' : 'application/json'
			}
		}).then(function(response) {
			return response.json()
		})
	}

	function updateUser(id, user) {
		return fetch('https://secret-earth-88750.herokuapp.com/api/users/' + id, {
			method : 'PUT',
			body : JSON.stringify(user),
			headers : {
				'content-type' : 'application/json'
			}
		}).then(function(response) {
			return response.json()
		})
	}

	function deleteUser(id) {
		return fetch('https://secret-earth-88750.herokuapp.com/api/users/' + id, {
			method : 'DELETE'

		}).then(function(response) {
			return response.json()
		})
	}

	function createUser(user) {
		user.id = (new Date()).getTime();
		return fetch('https://secret-earth-88750.herokuapp.com/api/users', {
			method : 'POST',
			body : JSON.stringify(user),
			headers : {
				'content-type' : 'application/json'
			}
		}).then(function(response) {
			return response.json()
		})
	}

	function findAllUsers() {
		return fetch('https://secret-earth-88750.herokuapp.com/api/users').then(
				function(response) {
					return response.json()
				})
	}
}