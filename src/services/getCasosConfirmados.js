import api from './api';

const getCasosConfirmados = async () => {
    const pacientes = await api.getPacients();
    
    console.log(pacientes);

    return pacientes.patients.filter((patiente) => {
       return patiente.corona ? patiente.corona.toUpperCase() == 'CONFIRMED' : false; 
    }).length;
}

export default getCasosConfirmados;