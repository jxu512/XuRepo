/*
https://leetcode.com/problems/subdomain-visit-count/description/
 */
package demos.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        int n = cpdomains.length;
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i=0;i<n;i++) {
            String[] tmp = cpdomains[i].split(" ");
            int count = Integer.parseInt(tmp[0]);
            String domain = tmp[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            int idx1 = tmp[1].indexOf(".");
            int idx2 = tmp[1].lastIndexOf(".");
            String parent;
            if (idx1>0) {
                parent = domain.substring(idx1+1);
                map.put(parent, map.getOrDefault(parent, 0) + count);
            }
            if (idx2>idx1) {
                parent = domain.substring(idx2+1);
                map.put(parent, map.getOrDefault(parent, 0) + count);
            }
        }
        map.forEach((k,v)->list.add(v + " " + k));
        return list;
    }
}
