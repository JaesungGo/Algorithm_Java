## 문제 파악

LV3. 가장 먼 노드
n 개의 노드 그래프
각 노드는 1~n
1번 노드에서 가장 멀리 떨어진 노드의 개수
가장 멀리 떨어진 노드는 최단 경로로 이동 했을 때 간선의 개수가 가장 많은 노드들

노드의 개수 n , 간선 정보 2차원 배열 vertex

1번 노드로부터 가장 멀리 떨어진 노드의 개수를 return

제한사항
2 <= n <= 20,000
간선 양방향 1 <= 간선 <=50,000
vertex[a,b] -> a와 b사이에 간선

## 접근 방법

bfs 로 풀기 (count++)

1. vertex를 인접 리스트로 만들기
2. 거리 큐 추가해서 bfs진행

v.length == 간선의 개수

ex )
[
{1: 2,3 }.
{2: 1,3,4},
{3: 1,2,6},
{4 :2,3 },
{5: 2 },
{6: 3}
]

graph.get( ) = vertex[0][0] => key
vertex[0][1] => value