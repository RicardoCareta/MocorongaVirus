import React, { useState } from "react";

import {
    TextField,
    FormControlLabel,
    RadioGroup,
    FormLabel,
    Radio
} from "@material-ui/core";

import "./style.css";
import api from "../../services/api";
import Alert from "../alert";

function FormPatient() {
    const [fieldRisk, setFieldRisk] = useState("");
    const [fieldName, setFieldName] = useState("");
    const [fieldAge, setFieldAge] = useState("");
    const [fieldPrognostic, setFieldPrognostic] = useState("");

    const [openAlert, setOpenAlert] = useState(false);

    const closeAlertAddPaciente = () =>{
        setOpenAlert(false);
        setFieldRisk("");
        setFieldName("");
        setFieldAge("");
        setFieldPrognostic("");
    }

    const addPacient = async () => {
        await api.postPaciente(fieldName, fieldAge, fieldPrognostic, fieldRisk, "PENDING", "GENERAL_PRACTITIONER", "WAITING");
        //alert('Paciente cadastrado com sucesso');
        setOpenAlert(true);
        setFieldRisk("");
        setFieldName("");
        setFieldAge("");
        setFieldPrognostic("");
    }

    return (
        <div className="checkUp-form">
            <Alert 
                message="Paciente cadastrado com sucesso!"
                handleClose={closeAlertAddPaciente}
                open={openAlert}
                />
            <div className="checkUp-row">
                <div className="field-name">
                    <TextField
                        variant="outlined"
                        label="Nome completo"
                        fullWidth={true}
                        onChange={e => setFieldName(e.target.value)}
                        value={fieldName}
                    />
                </div>

                <div className="field-age">
                    <TextField
                        type="number"
                        variant="outlined"
                        label="Idade"
                        fullWidth={true}
                        onChange={e => setFieldAge(e.target.value)}
                        value={fieldAge}
                    />
                </div>
            </div>

            <div className="checkUp-row">
                <div className="field-prognostic">
                    <TextField
                        multiline={true}
                        variant="outlined"
                        label="Prognóstico"
                        fullWidth={true}
                        onChange={e => setFieldPrognostic(e.target.value)}
                        value={fieldPrognostic}
                    />
                </div>
            </div>

            <div className="checkUp-row">
                <div className="field-risk">
                    <FormLabel component="legend">Risco</FormLabel>
                    <RadioGroup aria-label="position" name="position" row
                        value={fieldRisk} onChange={e => setFieldRisk(e.target.value)}

                    >
                        <FormControlLabel
                            value="NOT"
                            control={<Radio color="primary" />}
                            label="NÃO URGENTE"
                            labelPlacement="end"
                        />
                        <FormControlLabel
                            value="LITTLE"
                            control={<Radio color="primary" />}
                            label="POUCO URGENTE"
                            labelPlacement="end"
                        />

                        <FormControlLabel
                            value="URGENCY"
                            control={<Radio color="primary" />}
                            label="URGENTE"
                            labelPlacement="end"
                        />

                        <FormControlLabel
                            value="EMERGENCY"
                            control={<Radio color="primary" />}
                            label="EMERGÊNCIA"
                            labelPlacement="end"
                        />
                    </RadioGroup>
                </div>
            </div>

            <div id="send">
                <input type="button" value="Enviar" id="sendBtn" onClick={addPacient}/>
            </div>
        </div>
    );
}

export default FormPatient;
