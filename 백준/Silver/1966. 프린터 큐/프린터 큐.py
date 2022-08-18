t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    docs = list(map(int, input().split()))
    v = docs[m]

    arr = []
    for i in range(len(docs)):
        arr.append([i, docs[i]])

    ans = []
    while len(arr) > 0:
        if max(docs) != arr[0][1]:
            arr.append(arr[0])
            arr.pop(0)
        else:
            ans.append(arr.pop(0))
            docs.remove(max(docs))

    print(ans.index([m, v]) + 1)
