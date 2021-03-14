import { Component, OnInit } from '@angular/core';
import { PrimeDTO } from 'src/models/prime.dto';
import { PrimeService } from 'src/app/services/prime.service'

import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss']
})
export class HomePage implements OnInit {

  lower: number
  top: number

  inDatabase: PrimeDTO[] = []

  addedPrime: PrimeDTO

  primesinselectedrange: string = ""

  selectedLower: Number
  selectedTop: Number

  selectedRange: PrimeDTO

  constructor(
    public service : PrimeService,
    public alertController: AlertController
  ) {
  }

  ngOnInit() {
    this.getAll()
  }

  getAll(){
    this.service.findAll()
    .subscribe((data: PrimeDTO[]) => this.inDatabase = data)
  }

  generatePrimes(low, top){
    this.selectedLower = low
    this.selectedTop = top
    const n1 = Number(low)
    const n2 = Number(top)
    if (isNaN(n1) || isNaN(n2)) {
        this.presentAlert("The entry for the range needs to be a number")
    } else {
      if(n2 < n1) {
        this.presentAlert("The top range can't be bigger than the lower.")
      } else {
        console.log("adding "+low+"  " +top)
        this.service.add(low,top)
        .subscribe((data: PrimeDTO) => {
          this.addedPrime = data
          this.getAll()
          this.getLastAdded(low, top)
        })
      }
    }
  }

  getLastAdded(low, top) {
    this.service.getByLowTop(low, top)
    .subscribe((data: PrimeDTO) => {
      this.addedPrime = data
      this.primesinselectedrange = data.resultSet.join().split(",").join(", ")
    })
  }

  async presentAlert(error: string) {
    const alert = await this.alertController.create({
      cssClass: 'my-custom-class',
      header: 'Attention!',
      subHeader: '',
      message: error,
      buttons: ['OK']
    });

    await alert.present();
  }

  getPrimesInRange(){
    this.selectedLower = this.selectedRange.lowerRange
    this.selectedTop = this.selectedRange.topRange
    this.primesinselectedrange = this.selectedRange.resultSet.join().split(",").join(", ")
  }


}
