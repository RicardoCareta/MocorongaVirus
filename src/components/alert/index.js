import React from 'react';
import { Dialog, DialogTitle, Button, DialogActions } from '@material-ui/core';

function Alert({ message, open, handleClose }) {
    return (
        <Dialog
            open={open}
            onClose={handleClose}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description"
        >
            <DialogTitle id="alert-dialog-title">{message}</DialogTitle>
            <DialogActions>
                <Button onClick={handleClose} color="primary">OK!</Button>
            </DialogActions>
        </Dialog>
    )
}

export default Alert;