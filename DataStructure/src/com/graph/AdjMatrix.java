package com.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @�ٷ���վ : https://douma.ke.qq.com
 * @΢�Ź��ں� : �������
 * @�ٷ�΢�ź� : bigdatatang01
 * @���� : ����
 */
// �ռ临�Ӷȣ�O(V^2)���˷ѿռ�
public class AdjMatrix implements Graph {
    private int V; // ����ĸ���
    private int E; // �ߵĸ���
    private int[][] adj; // �ڽӾ���

    // ��ͼʱ�临�Ӷȣ�O(E)
    public AdjMatrix(String fileName) {
        try {
            BufferedReader reader
                    = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            String[] arr = line.split(" ");
            this.V = Integer.valueOf(arr[0]);
            this.E = Integer.valueOf(arr[1]);

            this.adj = new int[V][V];
            while ((line = reader.readLine()) != null) {
                arr = line.split(" ");
                int a = Integer.valueOf(arr[0]);
                validateVertex(a);
                int b = Integer.valueOf(arr[1]);
                validateVertex(b);
                // ����Ի���
                if (a == b) {
                    throw new RuntimeException("�������Ի��ߣ�����");
                }
                // ���ƽ�б�
                if (adj[a][b] == 1) {
                    throw new RuntimeException("������ƽ�бߣ�����");
                }
                adj[a][b] = 1;
                adj[b][a] = 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException(String.format("���� %d ���ϸ�", v));
        }
    }

    @Override
    public int getV() {
        return V;
    }
    @Override
    public int getE() {
        return E;
    }

    // �ж�����ָ���Ķ���֮���Ƿ��б�
    // ʱ�临�Ӷȣ�O(1)
    @Override
    public boolean hasEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);

        return adj[v][w] == 1;
    }

    // ��ȡָ�������������ڵĶ���
    // ʱ�临�Ӷȣ�O(V)
    @Override
    public Collection<Integer> adj(int v) {
        validateVertex(v);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    // ��ȡָ������Ķ���
    @Override
    public int degree(int v) {
        return adj(v).size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("������ = %d������ = %d \n", V, E));
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                sb.append(adj[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjMatrix adjMatrix = new AdjMatrix("data/graph");
        System.out.println(adjMatrix);
    }
}
