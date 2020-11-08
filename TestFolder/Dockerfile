name: Litmus-CI
on:
  issue_comment:
    types: [created, edited]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: octokit/request-action@v2.x
        id: get_PR_commits
        with:
          route: GET /repos/:repo/pulls/:pull_number/commits
          repo: ${{ github.repository }}
          pull_number: ${{ github.event.issue.number }}
        env:
          GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
      - name: set commit to output
        id: getcommit
        run: | 
           prsha=$(echo $response | jq '.[-1].sha'  | tr -d '"')
           echo "::set-output name=sha::$prsha" 
        env: 
          response:  ${{ steps.get_PR_commits.outputs.data }}
          
      - uses: actions/checkout@v2
        with:
          ref: ${{steps.getcommit.outputs.sha}}
