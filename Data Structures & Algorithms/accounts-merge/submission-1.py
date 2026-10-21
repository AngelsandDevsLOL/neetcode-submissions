class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        par = []
        def findParent(index: int) -> int:
            if par[index][1] == -1:
                return index
            par[index][1] = findParent(par[index][1])
            return par[index][1]
        index = {}
        for i in range(0, len(accounts)):
        # add name, add accounts to array 
        # dict of account to ind in array
        # point accounts to name using par 
        # if account is already in dictionary, then find parent and set the parent of one to another -- replace the other parent to be "" so that we know that it's a name !
        # loop through the accounts so that we can form our sets of 1 name and several emails
        # sort and return
            account = accounts[i]
            name = account[0]
            ind = len(par)
            par += [[name, -1]]
            index[name] = len(par) - 1
            for j in range(1, len(account)):
                if account[j] in index:
                    par1 = findParent(index[account[j]])
                    par2 = findParent(ind)
                    if par1 != par2:
                        par[par2][1] = par1
                        par[par2][0] = ""
                else:
                    par += [[account[j], ind]]
                    index[account[j]] = len(par) - 1
            
        emails = {}
        mapping = {}
        for i in range(0, len(par)):
            parent = findParent(i)
            if par[i][0] == "" or par[i][1] == -1: 
                continue;
            if parent in emails:
                emails[parent] += [par[i][0]]
            else:
                emails[parent] = [par[i][0]]
                mapping[parent] = par[parent][0]
        ret = []
        for key in mapping:
            lst = [mapping[key]]
            lst += sorted(emails[key])
            ret += [lst]
        return ret