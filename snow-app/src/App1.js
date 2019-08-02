import React, { Component } from 'react';
import './App.css'
import './TodoList.css'
import TodoList from './components/TodoList'
import TodoItems from './components/TodoItems'
import { conditionalExpression } from '@babel/types';

class App extends Component {
  inputElement = React.createRef()
  constructor() {
    console.log('print log')
    super()
    this.state = {
      items: [],
      currentItem: { text: '', key: '' }
    }
  }
  handleInput = e => {
    //e.preventDefault()
    const itemText = e.target.value
    //console.log('itemText' + itemText)
    const currentItem = { text: itemText, key: Date.now() }
    //console.log('currentItem.text' + currentItem.text)
    this.setState({
      currentItem
    })
  }
  addItem = e => {
    e.preventDefault()
    const newItem = this.state.currentItem
    if (newItem.text !== '') {
      console.log(newItem)
      const items = [...this.state.items, newItem]
      this.setState({
        items: items,
        currentItem: { text: '', key: '' }
      })
    }
    console.log('Hello Add Item')
  }
  deleteItem = key => {
    const filteredItems = this.state.items.filter(item => { 
      return item.key !== key
    })
    this.setState({
      items: filteredItems
    })
  }
  changeBackgrnd(){
    console.log("debug change color")
    //name.style.background-color = "red";
  }
  render() {
    return (
      <div className="TodoSpec"> <h1> ~ SNOW TODO List ~ </h1>
        <TodoList
          addItem={this.addItem}
          inputElement={this.inputElement}
          handleInput={this.handleInput}
          currentItem={this.state.currentItem}
        />
        <TodoItems entries={this.state.items} deleteItem={this.deleteItem} />
        <input id="name" className="DottedBox1" placeholder="Task"  onChange={changeBackgrnd()}/>
      </div>
    );
      
  }
}

export default App;