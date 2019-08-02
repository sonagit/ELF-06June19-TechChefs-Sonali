import React, { Component } from 'react'
class RadioCheck extends Component{
    render(){
        return(
            <div className="radioCheckMain">
                <div className="header">
                    <form>
                        <input type="checkbox" /> Add Task 
                    </form>
                </div>
            </div>
        )
    }
}
export default RadioCheck