import React from 'react';

import { Paper, Button } from '@material-ui/core';

import './styles.css';
import AlertIcon from '../IconsSVG/AlertIcon';
import CheckIcon from '../IconsSVG/CheckIcon';
import api from '../../services/api';

function CardPatient({ name, prognostic, age, key, id, fetchData }) {

    const setCoronaVirus = async () => {
        await api.setPatientCorona(id, true);
        fetchData()
        alert("Paciente alterado com sucesso");
    }

    const setAttends = async () => {
        await api.setPatientAttend(id);
        fetchData()
        alert("Paciente alterado com sucesso");
    } 

    return (
        <Paper elevation={3} className="card-patient">
            <div className="card-patient-header">
                <div className="card-patient-header-name-age">
                    <span>{name} ({age})</span>
                </div>
            </div>
            <div className="card-patient-body">
                <div className="card-patient-prognostic">
                    <span>{prognostic}</span>
                </div>
            </div>
            <div className="card-patient-footer">
                <div className="card-patient-footer-buttons">
                    <div className="card-patient-footer-corona">
                        <Button
                            color="primary"
                            variant="contained"
                            className="corona-button"
                            startIcon={<AlertIcon />}
                            children={""}
                            onClick={setCoronaVirus}
                        />
                    </div>

                    <div className="card-patient-footer-done">
                        <Button
                            color="primary"
                            variant="contained"
                            className="done-button"
                            startIcon={<CheckIcon />}
                            children={""}
                            onClick={setAttends} 
                        />
                    </div>
                </div>
            </div>
        </Paper>
    )
}

export default CardPatient;