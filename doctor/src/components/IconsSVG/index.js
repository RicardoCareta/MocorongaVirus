import React from 'react';
import { SvgIcon } from '@material-ui/core';

function IconsSVG(props) {
    return (
        <SvgIcon {...props}>
            <path d={props.path} />
        </SvgIcon>
    ) 
}

export default IconsSVG;