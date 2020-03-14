import React, { useState, useEffect } from "react";
import "./style.css";
import getCasosConfirmados from "../../services/getCasosConfirmados";

function CorongaCases() {

    const [countCorongaCases, setCountCorongaCases] = useState(0);

    const timeUpdateCoronga = async () => {
        setCountCorongaCases(await getCasosConfirmados());
    }

    useEffect(() => {
        timeUpdateCoronga();
        setInterval(timeUpdateCoronga, 5000);
    }, []);


    return (
        <div id="corongaCases">
            <div id="poster">
                <div id="image">
                    <img
                        src="https://img.icons8.com/color/480/coronavirus.png"
                        id="coronaImg"
                        alt="COVID-19"
                        title="Corona Vírus"
                    />
                </div>

                <div id="title">
                    <h1> COVID-19 </h1>
                </div>

                <div id="cases">
                    <h2>Casos confirmados: {countCorongaCases}</h2>
                    <p>
                        Casos de corona detectados neste centro médico atualizados em tempo
                        real.
          </p>
                </div>
            </div>
        </div>
    );
}

export default CorongaCases;
