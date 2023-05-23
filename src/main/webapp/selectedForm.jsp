<form action="quizstart" class="m-2 p-2">
    <div class="form-group row">
        <label for="category" class="h4">Choose a Category:</label>
        <select id="category" name="category" class="p-1 m-1">
            <option selected>Choose...</option>
            <option value=9>General Knowledge</option>
            <option value=10>Books</option>
            <option value=11>Film</option>
            <option value=12>Music</option>
            <option value=13>Musical Theatre</option>
            <option value=14>TV</option>
            <option value=15>Video Games</option>
            <option value=16>Board Games</option>
            <option value=17>Science &amp; Nature</option>
            <option value=18>Computers</option>
            <option value=19>Mathematics</option>
            <option value=20>Mythology</option>
            <option value=21>Sports</option>
            <option value=22>Geography</option>
            <option value=23>History</option>
            <option value=24>Politics</option>
            <option value=25>Art</option>
            <option value=26>Celebrities</option>
            <option value=27>Animals</option>
            <option value=28>Vehicles</option>
            <option value=29>Comics</option>
            <option value=30>Science: Gadgets</option>
            <option value=31>Japanese Anime &amp; Manga</option>
            <option value=32>Cartoons &amp; Animations</option>
        </select>
    </div>


    <fieldset class="form-group row">
        <legend class="h4">Difficulty Setting</legend>
        <div class="form-check">
            <input type="radio" name="difficulty" id="easy" value="easy" checked>
            <label for="easy">Easy</label>
        </div>
        <div class="form-check">
            <input type="radio" name="difficulty" id="medium" value="medium">
            <label for="medium">Medium</label>
        </div>
        <div class="form-check">
            <input type="radio" name="difficulty" id="hard" value="hard">
            <label for="hard">Hard</label>
        </div>
    </fieldset>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" name="submit" value="quiz" class="btn btn-primary m-1">Submit</button>
        </div>
    </div>
</form>