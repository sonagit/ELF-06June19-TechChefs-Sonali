import React, { Component } from 'react'
class TodoItems extends Component{
    createTasks = item => {
        return (
        <li style={{color:'red'}} key={item.key} onClick={() => this.props.deleteItem(item.key)}>{item.text}
        </li>
        )
    }
    render(){
        const todoEntries = this.props.entries
        const listItems = todoEntries.map(this.createTasks)
        return <ul classname="theList"> {listItems} </ul>
    }
}
export default TodoItems