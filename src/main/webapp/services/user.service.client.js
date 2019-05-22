function UserService() {
	this.findAllUsers = findAllUsers;
	this.createUser = createUser;
	this.deleteUser = deleteUser;
	
	function deleteUser(id) {
		return fetch('http://localhost:8080/api/users/'+id,{
			method : 'DELETE'
				
		}).then(function(response) {
			return response.json()
		})
	}

	function createUser(user) {
		user.id = (new Date()).getTime();
		return fetch('http://localhost:8080/api/users', {
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
		return fetch('http://localhost:8080/api/users').then(
				function(response) {
					return response.json()
				})
	}
}