// https://www.hackerrank.com/challenges/lisa-workbook/problem?h_r=next-challenge&h_v=zen
package code.hackerrank

fun workbook(n: Int, k: Int, arr: Array<Int>): Int {
    var page = 1
    var special = 0

    arr.forEachIndexed { chapter, chapterProblems ->
        var pageIndex = 0

        for (problem in (1..chapterProblems)) {
            if (pageIndex == k) {
                // if we've put the total number of problems on this page, goto next
                page += 1 //start a new page
                pageIndex = 1
            } else {
                pageIndex += 1
            }

            if (problem == page)
                special += 1
        }

        page += 1
    }

    return special
}

/*
problem is special if
- its index (within a chapter) == page number

n   - # of chapters (1 to n)
k   - max number of problems per page
arr - number of problems in each chapter
    i - chapter has arr[i] problems (1 to arr[i])


n = 5
k = 3
arr = [4,2,6,1,10]

overallPage = 0

arr.forEach { problems, index ->
    chapter = 1 // index + 1
    problems = 4 // same as arr[index]

    // pages = problems / k = 1.3
    pages = floor(1.3) // problems / k
    remainder = 4 % 3 = 1 // problems % k

    // attempt to use pages + remainder:
        fullPages = range 1 .. pages
        remainProblems = problems % k
        if remainProblems, total pages = fullPages + 1

        foreach fullPages
            overallPage += 1 // page 1
            for problem in 1..k
                problem 1
                problem 2
                problem 3
                // find `special` problem

        if remainProblems
            overallPage += 1
            for problem in remainProblems
                page = 2
                problem 4
                // find `special` problem

    // attempt 2
    page = 1
    used = 0
    for problem in 1..problems // arr[index]
        // how to deal with per page?
        if (used == k) { // if we've put the total number of problems on this page, goto next
            page += 1 //start a new page
            used = 0
        }

        page=1, problem=1
        page=1, problem 2
        page=1, problem 3
        page=2, problem 4



}
 */