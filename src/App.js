import React, {useEffect} from "react";
import "./styles.css";
import CheckUp from "./screens/checkUpScreen";
import { ThemeProvider, createMuiTheme } from "@material-ui/core";

import getCasosConfirmados from './services/getCasosConfirmados';

export default function App() {
  const theme = createMuiTheme({
    palette: {
      primary: {
        main: "#07e3c5"
      }
    }
  })
  return (
    <div className="App">
      <ThemeProvider theme={theme}>
        <CheckUp />
      </ThemeProvider>
    </div>
  );

}
