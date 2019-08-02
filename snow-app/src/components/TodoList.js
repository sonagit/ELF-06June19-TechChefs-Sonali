import React, { Component } from 'react'
class TodoList extends Component{
    componentDidUpdate(){
        this.props.inputElement.current.focus()
    }
    
    render(){
        return(
            <div className="todoListMain">
                <div className="header">
                    <form onSubmit={this.props.addItem}>
                        <input style={{backgroundColor: this.props.color, fontSize:20, width : 500}}
                        placeholder="Task" 
                        ref={this.props.inputElement}
                        value={this.props.currentItem.text}
                        onChange={this.props.handleInput}
                        />
                        <button className= "DottedBox_content" type="submit"> Add Task </button>
                    </form>
                </div>
            </div>
        )
    }
}
export default TodoList