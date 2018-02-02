import { Injectable } from '@angular/core';
import { Book} from './bookpojo';
import { books } from './bookmodel';
@Injectable()
export class viewservice{

    loadbook() : Book[]{
        console.log(books);
        return books;

    }
}