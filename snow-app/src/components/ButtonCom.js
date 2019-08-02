import Button from 'react-bootstrap/Button'
import ButtonToolbar from 'react-bootstrap/ButtonToolbar'
import React, { Component } from 'react'
import '../App.css'

class ButtonCom extends Component {
    render() {
        return (
            <ButtonToolbar >
                <Button variant="primary">Primary</Button>
                <Button variant="secondary">Secondary</Button>
                <Button variant="success">Success</Button>
                <Button variant="warning">Warning</Button>
                <Button variant="danger">Danger</Button>
                <Button variant="info">Info</Button>
                <Button variant="light">Light</Button>
                <Button variant="dark">Dark</Button>
                <Button variant="link">Link</Button>
            </ButtonToolbar>
        )
    }
}
export default ButtonCom