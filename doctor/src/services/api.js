const host = "http://localhost:8080";

//http://www.mocky.io/v2/5e6f8139330000aab2f07a1b

const api = {

    getPatients : async (filter) => {
        const response = await fetch(host + "/patient");
        const data = await response.json();
        const patients = data.patient
        if(filter){
            return patients.filter(filter);
        }
        return patients;
    },

    setPatientCorona : async (idPatient, isCorona) => {
        await fetch(host + "/patient/" + idPatient + "/" + isCorona, {
            method : 'PATCH',
            headers : {
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            }
        });
    },

    setPatientAttend : async (idPatient) => {
        await fetch(host  +"/patient/attend/" + idPatient, {
            method: "PATCH",
            headers : { 
                'Accept' : 'application/json',
                'Content-Type' : 'application/json'
            },
        })
    }
}

export default api;