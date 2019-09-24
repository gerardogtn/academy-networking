console.log("A new request will start")
axios.get('https://swapi.co/api/planets/?page=1')
    .then(function (response) {
        console.log(response)
        console.log(response.data.results[0].name)
    })
    .catch(function (error) {
        console.log(error)
    })
console.log("Request has been set up")