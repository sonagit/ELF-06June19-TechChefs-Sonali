import Carousel from 'react-bootstrap/Carousel'
import CarouselItem from 'react-bootstrap/CarouselItem'
import CarouselCaption from 'react-bootstrap/CarouselCaption'
import React, { Component } from 'react'
import '../App.css'

class CarouselCom extends Component {
    showCar = value =>{
        return (<Carousel>
            <CarouselItem><img src={value} alt="Image Missing" /></CarouselItem>
             <CarouselCaption> First Image</CarouselCaption>
        </Carousel>)
    }
    render() {
        const imagescar = this.props.images
        let imagearr = []
        for (const [index, value] of imagescar) {
            imagearr.push(this.showCar(value))
        }
        
        return (
            <div>
                {imagearr}
            </div>
        )
    }
}
export default CarouselCom