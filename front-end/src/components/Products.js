import React, { Component } from 'react'

export default class Products extends Component{

    state = {
        id:'',
        productName: '',
        price: '',
        unit: '',
        pictureUrl: '',
    }
    constructor(props) {
        super(props);
        this.state = {
        }
    }

    async componentWillMount() {
        let products = await (await fetch('http://localhost:8080/products')).json();
        this.setState({ products });
    }
    render() {
        let { products = [] } = this.state;
        return (<div>产品展示
            
                    {products.map(({productName, price, unit, pictureUrl}) =>
                            <div >
                                 <p>产品名称 : {productName}</p>
                                 <p>价格 :{price}</p>
                                 <p>单位:{unit}</p>
                                 <p>图片:{pictureUrl}</p>
                            </div>
                   )}

                </div>
        );
    }
}