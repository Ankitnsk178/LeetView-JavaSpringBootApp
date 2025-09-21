
// Profile Stats
String query = """
    query userPublicProfile($username: String!){
        matchedUser(username: $username) {
            contestBadge {name
                 expired
                 hoverText
                 icon
            }
            username
            githubUrl
            twitterUrl
            linkedinUrl
            profile {
                ranking
                userAvatar
                realName
                aboutMe
                school
                websites
                countryName
                company
                jobTitle
                skillTags
                postViewCount
                postViewCountDiff
                reputation
                reputationDiff
                solutionCount
                solutionCountDiff
                categoryDiscussCount
                categoryDiscussCountDiff
                certificationLevel
            }
        }
    }
""";



// Contest Ranking ans History
String query = """
    query userContestRankingInfo($username: String!) {
        userContestRanking(username: $username) {
            attendedContestsCount
            rating
            globalRanking
            totalParticipants
            topPercentage
            badge {
                name
            }
        }
        userContestRankingHistory(username: $username) {
            attended
            trendDirection
            problemsSolved
            totalProblems
            finishTimeInSeconds
            rating
            ranking
            contest {
                title
                tartTime
            }
        }
    }
""";



// Number of questions solved
// Here variable name is userSlug
String query = """
     query userProfileUserQuestionProgressV2($userSlug: String!) {
        userProfileUserQuestionProgressV2(userSlug: $userSlug) {
            numAcceptedQuestions {
                count
                difficulty
            }
            numFailedQuestions {
                count
                difficulty
            }
            numUntouchedQuestions {
                count
                difficulty
            }
            userSessionBeatsPercentage {
                difficulty
                percentage
            }
            totalQuestionBeatsPercentage
        }
    }      
""";



// Total Questions and AC Submission
String query = """
    query userSessionProgress($username: String!) {
        allQuestionsCount {
            difficulty
            count
        }
        matchedUser(username: $username) {
            submitStats {
                acSubmissionNum {
                    difficulty
                    count
                    submissions
                }
                totalSubmissionNum {
                    difficulty
                    count
                    submissions
                }
            }
        }
    }   
""";



// Badges
String query = """
    query userBadges($username: String!) {
        matchedUser(username: $username) {
            badges {
                id
                name
                shortName
                displayName
                icon
                hoverText
                medal {
                    slug
                    config {
                        iconGif
                        iconGifBackground
                    }
                }
                creationDate
                category
            }
            upcomingBadges {
                name
                icon
                progress
            }
        }
    }   
""";



// User Profile Calendar -> Active years, Submission Calendar
String query = """
    query userProfileCalendar($username: String!, $year: Int) {
        matchedUser(username: $username) {
            userCalendar(year: $year) {
                activeYears
                streak
                totalActiveDays
                dccBadges {
                    timestamp
                    badge {
                        name
                        icon
                    }
                }
                submissionCalendar
            }
        }
    } 
""";



// Recent Submissions
String query = """
    query recentAcSubmissions($username: String!, $limit: Int!) {
        recentAcSubmissionList(username: $username, limit: $limit) {
            id
            title
            titleSlug
            timestamp
        }
    }    
"""
















