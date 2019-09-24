async function getPlanets() {
	try {
		const response = await axios.get('https://swapi.co/api/planets/?page=1')
        console.log(response)
        console.log(response.data.results[0].name)
	} catch (error) {
		console.log(error)
	}
}

console.log("A new request will start")
getPlanets()
console.log("Request has been set up")