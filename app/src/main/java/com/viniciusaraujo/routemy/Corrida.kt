package com.viniciusaraujo.routemy

class Corrida {

    private var kms:Float=0.1f
    private var cost:Float=0.1f
    private var price:Float=0.1f
    private var lucre:Float=0.1f


    fun getKms():Float{
        return this.kms
    }
    fun setKms(value:Float){
        this.kms=value
    }
    fun getCost():Float{
        return this.cost
    }
    fun setCost(value:Float){
        this.cost=value
    }
    fun getPrice():Float{
        return this.price
    }
    fun setPrice(value: Float){
        this.price=value
    }
    fun getLucre():Float{
        return this.lucre
    }
    fun setLucre(value: Float){
        this.lucre=value
    }
}