import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MaxRatingService {
  static createMaxRatingList(maxRating: number) {
    return Array(maxRating).fill(maxRating).map((x, i) => i);
  }
}
