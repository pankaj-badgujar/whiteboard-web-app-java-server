function UserService() {
	this.findAllUsers = findAllUsers;
		
	function findAllUsers() {
        return fetch('http://localhost:8080/api/users')
            .then(function(response){
                return response.json()
        })
    }
}