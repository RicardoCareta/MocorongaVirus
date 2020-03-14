import React from "react";
import "./style.css";

function Header() {
  return (
    <div id="header">
      <div id="head">
        <div id="logo">
          <img
            src="https://www.shareicon.net/data/2016/03/15/734048_doctor_512x512.png"
            alt="Logo"
            id="LogoMed"
          />
        </div>
        <div id="text">
          <h2>MedicalCenter</h2>
        </div>
      </div>
    </div>
  );
}

export default Header;
