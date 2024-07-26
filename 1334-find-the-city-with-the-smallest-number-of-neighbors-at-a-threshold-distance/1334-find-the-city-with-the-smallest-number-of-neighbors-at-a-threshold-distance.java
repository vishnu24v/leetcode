class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int distGraph[][] = new int[n][n];

        for (int city = 0; city < n; city++) {
            Arrays.fill(distGraph[city], Integer.MAX_VALUE);
            distGraph[city][city] = 0; 
        }

        for (var edg : edges) {
            distGraph[edg[0]][edg[1]] = edg[2];
            distGraph[edg[1]][edg[0]] = edg[2];
        }

        for (int intermediateCity = 0; intermediateCity < n; intermediateCity++) {
            for (int firstCity = 0; firstCity < n; firstCity++) {
                for (int secondCity = 0; secondCity < n; secondCity++) {
                    if (distGraph[firstCity][intermediateCity] != Integer.MAX_VALUE &&
                        distGraph[intermediateCity][secondCity] != Integer.MAX_VALUE) {
                        distGraph[firstCity][secondCity] = Math.min(
                            distGraph[firstCity][secondCity],
                            distGraph[firstCity][intermediateCity] + distGraph[intermediateCity][secondCity]
                        );
                    }
                }
            }
        }

        int minReach = Integer.MAX_VALUE, answerCity = -1;

        for (int srcCity = 0; srcCity < n; srcCity++) {
            int srcCityReach = 0;
            for (int destCity = 0; destCity < n; destCity++) {
                if (srcCity != destCity && distGraph[srcCity][destCity] <= distanceThreshold) {
                    srcCityReach++;
                }
            }
            if (srcCityReach <= minReach) {
                minReach = srcCityReach;
                answerCity = srcCity;
            }
        }

        return answerCity;
    }
}