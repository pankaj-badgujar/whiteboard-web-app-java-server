function UserService() {
	this.findAllUsers = findAllUsers;
	this.createUser = createUser;

	function createUser(user) {
		user.id = (new Date()).getTime();
		console.log(user);
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