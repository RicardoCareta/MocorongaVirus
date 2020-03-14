
const host = 'http://192.168.1.102:3000';
const api = {
    getPacients: async () => {
        const response = await fetch(host + "/patients");
        return await response.json();
    },

    postPaciente: async (name,
        age,
        prognostic,
        risk,
        corona,
        doctor,
        status) => {

        fetch(host + "/patient", {
            method: "POST",
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify({
                name,
                age,
                prognostic,
                risk,
                corona,
                doctor,
                status
            })
        });
    }
};

export default api;