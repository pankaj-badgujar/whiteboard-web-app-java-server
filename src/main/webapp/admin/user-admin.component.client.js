(function() {
	const users = [ {
		id : 123,
		username : 'alice',
		firstName : 'Alice'
	}, {
		id : 234,
		username : 'bob',
		firstName : 'Bob'
	}, {
		id : 345,
		username : 'charlie',
		firstName : 'Charlie'
	}, {
		id : 456,
		username : 'dan',
		firstName : 'Dan'
	} ];

	const rowTemplate = $('.wbdv-template')
	const tBody = $('tbody');
	for ( var i in users) {
		const user = users[i];
		const rowClone = rowTemplate.clone();
		rowClone.removeClass('wbdv-hidden');
		rowClone.find('.wbdv-username').html(users[i].username); 
		tBody.append(rowClone);
	}

})()















