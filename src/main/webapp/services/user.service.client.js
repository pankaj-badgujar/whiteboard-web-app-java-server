function UserService() {
	this.findAllUsers = findAllUsers;
	this.createUser = createUser;
	
	function createUser(user){
		alert("yep got created");
		console.log(user);
	}
		
	function findAllUsers() {
        return fetch('http://localhost:8080/api/users')
            .then(function(response){
                return response.json()
        })
    }
}