import React from "react";
import "./style.css";
import CorongaCases from "../../components/corongaCases";
import Header from "../../components/header";
import FormPatient from "../../components/form";

function CheckUp() {
  return (
    <div id="checkUpScreen">
      <div id="header">
        <Header />
      </div>

      <div id="container">
        <div id="coronga">
          <CorongaCases />
        </div>

        <div id="form">
          <FormPatient />
        </div>
      </div>
    </div>
  );
}

export default CheckUp;
