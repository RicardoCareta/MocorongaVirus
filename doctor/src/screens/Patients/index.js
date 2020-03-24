import React, { useEffect, useState } from 'react';
import CardPatient from '../../components/CardPatient';
import api from '../../services/api';

import './styles.css';


function Patients() {

    const [patients, setPatients] = useState([]);
    const fetchData = async () => {
        setPatients(await api.getPatients((patient) => {
            return !patient.corona && patient.status;
        }));
    }

    useEffect(() => {
        fetchData();
        setInterval(fetchData, 1000);
    }, [])
    return (
        <div className="form-patients">
            {
                patients.map((patient, idx) => 
                    <CardPatient name={patient.name} age={patient.age} prognostic={patient.prognostic} key={idx} id={patient.id} fetchData={fetchData}/>
                )
            }
           
        </div>
    )
}

export default Patients; 