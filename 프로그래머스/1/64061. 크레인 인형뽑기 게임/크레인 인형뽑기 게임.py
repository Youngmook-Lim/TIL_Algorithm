def solution(board, moves):
    n = len(board)
    moves = [i - 1 for i in moves]
    b = []
    cnt = 0
    
    for i in moves:
        for j in range(n):
            if board[j][i] != 0:
                b.append(board[j][i])
                board[j][i] = 0
            
                if len(b) >= 2:
                    if b[-1] == b[-2]:
                        b.pop()
                        b.pop()
                        cnt += 2
                break
                
    return cnt