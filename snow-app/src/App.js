import React, { Component } from 'react';
import './App.css'
import './TodoList.css'
import TodoList from './components/TodoList'
import TodoItems from './components/TodoItems'
import CarouselCom from './components/CarouselCom'
import { conditionalExpression } from '@babel/types';

class App extends Component {
  inputElement = React.createRef()
  constructor() {
    console.log('print log')
    super()
    const images = ['http://icons.iconarchive.com/icons/paomedia/small-n-flat/256/cat-icon.png',
                    'https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/580/cached.offlinehbpl.hbpl.co.uk/news/NST/Twitter_Logo_WhiteOnBlue-20190122114927359.jpg',
                    'https://cdn.business2community.com/wp-content/uploads/2012/11/twitter-small-business-marketing.jpe',
                    'http://www.macmillandictionaryblog.com/wp-content/uploads/2011/07/Small-Talk-image.jpg']; 
    this.state = {
      items: [],
      currentItem: { text: '', key: '' },
      color : 'green',
      imgsrc: images[0],
      images: ['http://icons.iconarchive.com/icons/paomedia/small-n-flat/256/cat-icon.png',
                    'https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/580/cached.offlinehbpl.hbpl.co.uk/news/NST/Twitter_Logo_WhiteOnBlue-20190122114927359.jpg',
                    'https://cdn.business2community.com/wp-content/uploads/2012/11/twitter-small-business-marketing.jpe',
                    'http://www.macmillandictionaryblog.com/wp-content/uploads/2011/07/Small-Talk-image.jpg']

    }
    console.log('print log' +this.state.imgsrc)
  }
  handleInput = e => {
    //e.preventDefault()
    const itemText = e.target.value
    console.log('itemText' + itemText.length)
    if(itemText.length%2 ==0 ){
      this.state.color = 'red'
    }else{
      this.state.color = 'green'
    }
    const currentItem = { text: itemText, key: Date.now() }
    this.setState({
      currentItem,
      color : this.state.color,
      imgsrc: this.state.imgsrc,
      images: this.state.images
    })
    console.log('handleInput' +this.state.imgsrc)
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
          color={this.state.color}
          imgsrc={this.state.imgsrc}
        />
        <TodoItems entries={this.state.items} deleteItem={this.deleteItem} />
        <CarouselCom images={this.state.images} />
       </div>
    );
      
  }
}

export default App;